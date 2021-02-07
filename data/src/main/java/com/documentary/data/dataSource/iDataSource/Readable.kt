package com.documentary.data.dataSource.iDataSource


interface Readable<O> {

    fun read(): O

    interface IO<I, O> {

        fun read(input: I): O
    }

    interface Suspendable<O> {

        suspend fun read(): O

        interface IO<I, O> {

            suspend fun read(input: I): O
        }

        interface IOLocal<I, O> {

            fun read(input: I): O
        }
    }
}