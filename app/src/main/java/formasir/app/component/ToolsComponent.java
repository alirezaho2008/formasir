package formasir.app.component;


import android.content.Intent;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import formasir.app.module.ToolsModule;
import retrofit2.Retrofit;

/**
 * Created by Alireza on 02/15/2019.
 */
@Component(modules = {ToolsModule.class})
@Singleton
public interface ToolsComponent {

    @Named("Retrofit") Retrofit getRetrofit();
    Intent getIntent();
//    RxEventBus getRxEventBus();

}
