package br.com.felipeacerbi.keddit.dagger.modules

import br.com.felipeacerbi.keddit.retrofit.RedditApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by felipe.acerbi on 31/05/2017.
 */
@Module
class NewsModule {

    @Provides
    @Singleton
    fun provideRedditApiService(retrofit: Retrofit): RedditApiService {
        return retrofit.create(RedditApiService::class.java)
    }
}