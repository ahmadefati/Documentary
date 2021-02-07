package com.documentary.data.dataSource.iDataSource

interface Writable<I> {

    fun write(input: I)

    interface IO<I, O> {

        fun write(input: I): O
    }

    interface Suspendable<I> {

        suspend fun write(input: I)

        interface IO<I, O> {

            suspend fun write(input: I): O
        }
    }
}