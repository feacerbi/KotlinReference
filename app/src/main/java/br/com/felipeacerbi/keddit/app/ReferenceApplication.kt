package br.com.felipeacerbi.keddit.app

import android.app.Application
import br.com.felipeacerbi.keddit.dagger.components.DaggerNewsComponent
import br.com.felipeacerbi.keddit.dagger.components.NewsComponent

/**
 * Created by felipe.acerbi on 31/05/2017.
 */
class ReferenceApplication : Application() {

    companion object{
        lateinit var newsComponent: NewsComponent
    }

    init {

    }

    override fun onCreate() {
        super.onCreate()

        newsComponent = DaggerNewsComponent.builder()
                //.appModule(AppModule(this)) - Not used
                //.newsModule(NewsModule()) - Not necessary
                .build()
    }
}