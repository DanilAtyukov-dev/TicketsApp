package ru.danilatyukov.presentation

import ru.danilatyukov.presentation.screens.tickets.TicketsFragmentViewModel

interface ViewModelProvider {
    fun mainViewModel() : MainViewModel
    fun ticketsFragmentViewModel(): TicketsFragmentViewModel
}