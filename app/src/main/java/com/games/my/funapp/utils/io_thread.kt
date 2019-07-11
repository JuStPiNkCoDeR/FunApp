package com.games.my.funapp.utils

import java.util.concurrent.Executors

private val io_executor = Executors.newSingleThreadExecutor()

fun ioThread(f : () -> Unit) {
    io_executor.execute(f)
}