package br.com.felipeacerbi.keddit.dagger.components

import br.com.felipeacerbi.keddit.dagger.modules.AppModule
import br.com.felipeacerbi.keddit.dagger.modules.NetworkModule
import br.com.felipeacerbi.keddit.dagger.modules.NewsModule
import br.com.felipeacerbi.keddit.fragments.NewsFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by felipe.acerbi on 31/05/2017.
 */

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NewsModule::class,
        NetworkModule::class)
)

interface NewsComponent {
    fun inject(newsFragment: NewsFragment)
}