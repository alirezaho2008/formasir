package formasir.app.module;

import android.content.Intent;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import formasir.app.helper.Urls;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Alireza on 02/15/2019.
 */

@Module
public class ToolsModule {

    @Provides
    @Singleton
    OkHttpClient getOkHttpClient() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)//new ConnectivityInterceptor(G.context)
                .retryOnConnectionFailure(true).addNetworkInterceptor(new StethoInterceptor());



        return builder.build();
    }

    @Provides
    @Singleton
    @Named("Retrofit")Retrofit getRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())/*.callAdapterFactories()*/
                .build();
    }

    @Provides
    Intent getIntent() {
        return new Intent();
    }

}
