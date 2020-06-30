package com.thiqah.newssample.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.thiqah.newssample.base.extension.setError
import com.thiqah.newssample.base.extension.setLoading
import com.thiqah.newssample.base.extension.setSuccess
import com.thiqah.newssample.base.model.Resource
import com.thiqah.newssample.base.viewmodel.BaseViewModel
import com.thiqah.newssample.data.source.model.News
import com.thiqah.newssample.domain.interactor.GetNewsUseCase
import dagger.hilt.android.scopes.ActivityScoped
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ActivityScoped
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : BaseViewModel() {

    val newsLiveData by lazy { MutableLiveData<Resource<List<News>>>() }

    fun getNews() {
        addDisposable(
            getNewsUseCase.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { newsLiveData.setLoading() }
                .subscribe({
                    newsLiveData.setSuccess(it)
                }, {
                    newsLiveData.setError(it.message)
                })
        )

    }
}