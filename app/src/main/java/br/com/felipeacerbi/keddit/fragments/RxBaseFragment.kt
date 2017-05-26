package br.com.felipeacerbi.keddit.fragments

import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by felipe.acerbi on 25/05/2017.
 */
open class RxBaseFragment : Fragment() {

    protected var subscriptions = CompositeDisposable()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeDisposable()
    }

    override fun onPause() {
        super.onPause()
        if(!subscriptions.isDisposed) subscriptions.dispose()
        subscriptions.clear()
    }
}