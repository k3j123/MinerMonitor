package k3j123.minermonitor.Retrofit;

import com.androidnetworking.interceptors.HttpLoggingInterceptor;

import k3j123.minermonitor.R;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by trong on 4/8/18.
 */

public class RetrofitClient {

        private static Retrofit retrofit = null;

        public static Retrofit getClient() {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.nanopool.org/v1/zec/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

            return retrofit;
        }
}
