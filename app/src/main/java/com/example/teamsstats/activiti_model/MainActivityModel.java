package com.example.teamsstats.activiti_model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.teamsstats.DataFactory;
import com.example.teamsstats.model.dto.full_model.FullModelScheduledMatches;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivityModel extends AndroidViewModel {

    private static final String TAG = "MainActivityModel";
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<FullModelScheduledMatches> mutableLiveData = new MutableLiveData<>();
    public LiveData<FullModelScheduledMatches> getMutableLiveData() {
        return mutableLiveData;
    }
    public MainActivityModel(@NonNull Application application) {
        super(application);
    }

    public void loadScheduledMatches(String competitions, String dateFrom, String dateTo, String status) {
        Disposable disposable = loadTournamentMatchesRx(competitions, dateFrom, dateTo, status)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FullModelScheduledMatches>() {
                    @Override
                    public void accept(FullModelScheduledMatches fullModelScheduledMatches) {
                        mutableLiveData.postValue(fullModelScheduledMatches);
                        Log.d(TAG, "acceptDownload: " + fullModelScheduledMatches.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        Log.d(TAG, "Error: " + throwable.getMessage());

                    }
                });
        compositeDisposable.add(disposable);
    }

    private Single<FullModelScheduledMatches> loadTournamentMatchesRx(String competitions, String dateFrom, String dateTo, String status) {
        return DataFactory.getData().getScheduledMatches(competitions, dateFrom, dateTo, status);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
