package com.example.a29ekim.ui.detail

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class SpokenLanguage {
    @SerializedName("english_name")
    @Expose
    private var englishName: String? = null

    @SerializedName("iso_639_1")
    @Expose
    private var iso6391: String? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    fun getEnglishName(): String? {
        return englishName
    }

    fun setEnglishName(englishName: String?) {
        this.englishName = englishName
    }

    fun getIso6391(): String? {
        return iso6391
    }

    fun setIso6391(iso6391: String?) {
        this.iso6391 = iso6391
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }
}