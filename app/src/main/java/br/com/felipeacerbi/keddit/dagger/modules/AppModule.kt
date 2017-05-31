package br.com.felipeacerbi.keddit.dagger.modules

import android.content.Context
import br.com.felipeacerbi.keddit.app.ReferenceApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by felipe.acerbi on 31/05/2017.
 */
@Module
class AppModule(val app: ReferenceApplication) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication(): ReferenceApplication = app

}