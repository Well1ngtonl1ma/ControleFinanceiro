package com.example.controlefinanceiro

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import com.example.controlefinanceiro.databinding.ActivityExpenseDetailBinding

class ExpenseDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_EXPENSE = "extra_expense"
    }

    private lateinit var binding: ActivityExpenseDetailBinding
    private var expense: Expense? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpenseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        expense = IntentCompat.getParcelableExtra(intent, EXTRA_EXPENSE, Expense::class.java)

        expense?.let { showExpense(it) }

        binding.btnMarkAsPaid.setOnClickListener {
            expense?.isPaid = true
            updateStatus(true)
        }
    }

    private fun showExpense(expense: Expense) {
        binding.tvTitle.text = expense.title
        binding.tvAmount.text = String.format("R$ %.2f", expense.amount)
        binding.tvCategory.text = expense.category
        binding.tvDate.text = expense.date
        binding.tvDescription.text = expense.description
        updateStatus(expense.isPaid)
    }

    private fun updateStatus(isPaid: Boolean) {
        if (isPaid) {
            binding.tvStatus.text = "Paga"
            binding.tvStatus.setTextColor(Color.parseColor("#2E7D32"))
            binding.btnMarkAsPaid.isEnabled = false
        } else {
            binding.tvStatus.text = "Pendente"
            binding.tvStatus.setTextColor(Color.parseColor("#C62828"))
            binding.btnMarkAsPaid.isEnabled = true
        }
    }
}
