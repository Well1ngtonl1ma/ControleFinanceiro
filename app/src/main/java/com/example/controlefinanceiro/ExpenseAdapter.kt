package com.example.controlefinanceiro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.controlefinanceiro.databinding.ItemExpenseBinding

class ExpenseAdapter(
    private val expenses: List<Expense>,
    private val onItemClick: (Expense) -> Unit
) : RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    class ExpenseViewHolder(val binding: ItemExpenseBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val binding = ItemExpenseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpenseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = expenses[position]

        holder.binding.tvTitle.text = expense.title
        holder.binding.tvCategory.text = expense.category
        holder.binding.tvDate.text = expense.date
        holder.binding.tvAmount.text = String.format("R$ %.2f", expense.amount)

        holder.binding.root.setOnClickListener {
            onItemClick(expense)
        }
    }

    override fun getItemCount(): Int = expenses.size
}
