package com.qingmei2.rhine.di

import com.qingmei2.rhine.http.service.ServiceManager
import com.qingmei2.rhine.http.service.UserinfoApi

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

const val SERVICE_MODULE_TAG = "serviceModule"

val serviceModule = Kodein.Module(SERVICE_MODULE_TAG) {

    bind<UserinfoApi>() with singleton {
        instance<Retrofit>().create(UserinfoApi::class.java)
    }

    bind<ServiceManager>() with singleton {
        ServiceManager(instance())
    }
}