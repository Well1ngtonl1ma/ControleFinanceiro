package com.example.controlefinanceiro

object MockData {

    val expenses = listOf(
        Expense(1, "Aluguel", "Moradia", 1200.00, "05/10/2026", "Aluguel do apartamento referente ao mês de outubro.", false),
        Expense(2, "Supermercado", "Alimentação", 450.75, "07/10/2026", "Compras do mês no supermercado do bairro.", true),
        Expense(3, "Conta de Luz", "Contas da Casa", 180.40, "10/10/2026", "Fatura de energia elétrica do mês.", false),
        Expense(4, "Internet", "Contas da Casa", 99.90, "12/10/2026", "Plano de internet fibra de 300 MB.", true),
        Expense(5, "Academia", "Saúde", 89.90, "15/10/2026", "Mensalidade da academia perto da faculdade.", false)
    )
}
