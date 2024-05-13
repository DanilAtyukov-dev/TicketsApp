package ru.danilatyukov.presentation.screens.tickets.main.offers

import android.graphics.Canvas
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacingItemDecoration(val verticalSpaceHeight: Int = 0, val horizontalSpaceWidth: Int = 0):  RecyclerView.ItemDecoration(){
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        for (i in 0 until parent.childCount) {

            if (i != parent.childCount - 1) {
                val child: View = parent.getChildAt(i)

                val params = child.layoutParams as RecyclerView.LayoutParams

                params.marginEnd = horizontalSpaceWidth

                child.layoutParams = params

            }
        }
    }
}