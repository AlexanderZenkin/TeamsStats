package com.example.teamsstats.activiti_model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.teamsstats.DataFactory;
import com.example.teamsstats.model.dto.full_model.FullModelTournamentTable;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TableActivityModel extends AndroidViewModel {

    private static final String TAG = "TableActivityModel";
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<FullModelTournamentTable> mutableLiveData = new MutableLiveData<>();
    public LiveData<FullModelTournamentTable> getMutableLiveData() {
        return mutableLiveData;
    }
    public TableActivityModel(@NonNull Application application) {
        super(application);
    }

    public void loadTournamentTable(String competitions) {
        Disposable disposable = loadTournamentTablesRx(competitions)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FullModelTournamentTable>() {
                    @Override
                    public void accept(FullModelTournamentTable fullModelTournamentTable) {
                        mutableLiveData.postValue(fullModelTournamentTable);
                        Log.d(TAG, "acceptDownload: " + fullModelTournamentTable);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        Log.d(TAG, "Error: " + throwable.getMessage());

                    }
                });
        compositeDisposable.add(disposable);
    }

    private Single<FullModelTournamentTable> loadTournamentTablesRx(String competitions) {
        return DataFactory.getData().getTournamentTable(competitions);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
