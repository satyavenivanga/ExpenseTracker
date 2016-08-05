function showaccounts(){
	$('#allAccount').css('display','block');
	$('#addTransaction,#viewIncome,#uploadTransaction,#viewExpense,#addIncome,#viewSavings').css('display','none');
}

function uploadTransaction(){
	$('#uploadTransaction').css('display','block');
	$('#addTransaction,#allAccount,#viewIncome,#viewExpense,#addIncome,#viewSavings').css('display','none');
}

function addtransaction(){
	$('#addTransaction').css('display','block');
	$('#viewIncome,#allAccount,#uploadTransaction,#viewExpense,#addIncome,#viewSavings').css('display','none');
}

function addIncome(){
	$('#addIncome').css('display','block');
	$('#addTransaction,#allAccount,#uploadTransaction,#viewExpense,#viewIncome,#viewSavings').css('display','none');
}

function viewIncome(){
	$('#viewIncome').css('display','block');
	$('#addTransaction,#allAccount,#uploadTransaction,#viewExpense,#addIncome,#viewSavings').css('display','none');
}

function viewSavings(){
	$('#viewSavings').css('display','block');
	$('#addTransaction,#allAccount,#uploadTransaction,#viewExpense,#addIncome,#viewIncome').css('display','none');
}

function viewExpense(){
	$('#viewExpense').css('display','block');
	$('#addTransaction,#allAccount,#uploadTransaction,#viewSavings,#addIncome,#viewIncome').css('display','none');
}
window.onload=function(){
	$('#allAccount').css('display','block');
	$('#addTransaction,#viewIncome,#uploadTransaction,#viewExpense,#addIncome,#viewSavings').css('display','none');
}
