package org.pursuit.unit_03_assessment.network;

import org.pursuit.unit_03_assessment.model.ZodiacApi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Zservice {
    @GET("JDVila/storybook/master/zodiac.json")
    Call<ZodiacApi> getZodiac();

}

