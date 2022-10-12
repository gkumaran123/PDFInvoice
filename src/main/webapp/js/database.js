$(document).ready( function () {
	 var table = $('#employeesTable').DataTable({
			"sAjaxSource": "PDFInvoice/API/Employee/getEmployees",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "employee_id"},
		      { "mData": "employee_name" },
				  { "employee_email": "lastName" },
				  { "employee_branch": "email" }
		
			]
	 })
});