package com.example.couriertrack.Fragment.util

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.couriertrack.R

abstract class swipedelete(context: Context): ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
    private val deleteicon = ContextCompat.getDrawable(context, R.drawable.ic_baseline_delete_forever_24)
    private val intrinsicWidth = deleteicon?.intrinsicWidth
    private val intrinsicHeight = deleteicon?.intrinsicHeight


    private val background = ColorDrawable()
    private val backgroundcolor = Color.parseColor("#03A9F4")
    private val clearpaint = Paint().apply {
        xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder): Int {
        if (viewHolder?.adapterPosition == 10)return 0
            return super.getMovementFlags(recyclerView, viewHolder)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder): Boolean {
       return false
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean) {
        val itemview = viewHolder.itemView
        val itemheight = itemview.bottom - itemview.top
        val iscancel = dX == 0f && !isCurrentlyActive

        if(iscancel){
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            return
        }

        //background delete
        background.color = backgroundcolor
        background.setBounds(
            itemview.right + dX.toInt(),
            itemview.top,
            itemview.right,
            itemview.bottom)
        background.draw(c)

        //adjust icon
        val deleteicontop = itemview.top + (itemheight - intrinsicWidth!!) / 2
        val deleteiconmargin = (itemheight - intrinsicHeight!!) / 2
        val deleteiconleft = itemview.right - deleteiconmargin - intrinsicWidth
        val deleteiconright = itemview.right - deleteiconmargin
        val deleteiconbottom = deleteicontop + intrinsicHeight

        //draw icon
        deleteicon?.setBounds(deleteiconleft,deleteicontop,deleteiconright,deleteiconbottom)
        deleteicon?.draw(c)

        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }



}