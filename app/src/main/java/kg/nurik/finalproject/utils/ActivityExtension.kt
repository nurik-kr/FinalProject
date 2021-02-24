package kg.nurik.finalproject.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

import kotlin.reflect.KClass

fun <T : ViewModel> FragmentActivity.viewModel(clazz: KClass<T>) =
    lazy { ViewModelProviders.of(this).get(clazz.java) }

fun <T : ViewModel> Fragment.viewModel(clazz: KClass<T>) = lazy {
    ViewModelProviders.of(this).get(clazz.java)
}
