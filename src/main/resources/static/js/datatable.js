$(document).ready(function() {
				$("#employeeTable").DataTable({
						'aoColumnDefs': [{
        				'bSortable': false,
        				'aTargets': [-1] /* 1st one, start by the right */
    				}]
				});
			})