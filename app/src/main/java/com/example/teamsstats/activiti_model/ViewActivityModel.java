package com.example.teamsstats.activiti_model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.teamsstats.DataFactory;
import com.example.teamsstats.model.dto.full_model.FullModelH2HMatches;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ViewActivityModel extends AndroidViewModel {

    private static final String TAG = "ViewActivityModel";
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<FullModelH2HMatches> mutableLiveData = new MutableLiveData<>();
    public LiveData<FullModelH2HMatches> getMutableLiveData() {
        return mutableLiveData;
    }
    public ViewActivityModel(@NonNull Application application) {
        super(application);
    }

    public void loadH2HMatches(String matchId) {
        Disposable disposable = loadH2HMatchesRx(matchId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FullModelH2HMatches>() {
                    @Override
                    public void accept(FullModelH2HMatches fullModelH2HMatches) {
                        mutableLiveData.postValue(fullModelH2HMatches);
                        Log.d(TAG, "acceptDownload: " + fullModelH2HMatches.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        Log.d(TAG, "Error: " + throwable.getMessage());

                    }
                });
        compositeDisposable.add(disposable);
    }

    public void loadHomeAndAwayMatches(String matchId, String competitions, String venue) {
        Disposable disposable = loadHomeAndAwayMatchesRx(matchId, competitions, venue)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FullModelH2HMatches>() {
                    @Override
                    public void accept(FullModelH2HMatches fullModelH2HMatches) {
                        mutableLiveData.postValue(fullModelH2HMatches);
                        Log.d(TAG, "acceptDownload: " + fullModelH2HMatches);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        Log.d(TAG, "Error: " + throwable.getMessage());

                    }
                });
        compositeDisposable.add(disposable);
    }

    private Single<FullModelH2HMatches> loadH2HMatchesRx(String matchId) {
        return DataFactory.getData().getH2HMatches(matchId, "10");
    }

    private Single<FullModelH2HMatches> loadHomeAndAwayMatchesRx(String matchId, String competitions, String venue) {
        return DataFactory.getData().getHomeAndAwayMatches(matchId, "10", competitions, "FINISHED", venue);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
