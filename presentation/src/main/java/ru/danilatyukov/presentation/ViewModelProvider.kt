package ru.danilatyukov.presentation

import ru.danilatyukov.presentation.screens.tickets.main.TicketsFragmentViewModel

interface ViewModelProvider {
    fun mainViewModel() : MainViewModel
    fun ticketsFragmentViewModel(): TicketsFragmentViewModel
}