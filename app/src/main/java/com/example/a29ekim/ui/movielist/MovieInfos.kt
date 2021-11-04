package com.example.a29ekim.ui.movielist

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class MovieInfos{
    @SerializedName("page")
    @Expose
    var page: Int? = null

    @SerializedName("results")
    @Expose
    var results: List<ResultInfo>? = null

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null

    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null
}