package k3j123.minermonitor.Retrofit;

import k3j123.minermonitor.Model.BalanceModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by trong on 4/8/18.
 */

public interface RetrofitInterface {

    /*Get Balance*/
    @GET("balance/{address}")
    Call<BalanceModel> getBalance(@Path("address") String address);

    @GET("avghashrate/{address}")
    Call<AVGHashModel> getAVGHashrate(@Path("address") String address);

    @GET("hashrate/{address}")
    Call<CurrentHashrateModel> getCurrentHashrate(@Path("address") String address);
}
