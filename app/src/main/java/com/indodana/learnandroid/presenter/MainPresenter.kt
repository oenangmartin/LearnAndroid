package com.indodana.learnandroid.presenter

import com.indodana.learnandroid.contract.MainContract

class MainPresenter(
    private var view: MainContract.View?
) : MainContract.Presenter {
    override fun sumNumber(firstNumber: Int, secondNumber: Int) {
        val result = firstNumber + secondNumber

        view?.showResult(result)
    }

    override fun onDestroy() {
        view = null
    }
}