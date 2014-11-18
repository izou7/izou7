requirejs.config( {
	"baseUrl": "/static",
	"paths": {
		"jquery":               "libs/jquery/jquery-2.0.3.min",
		"bootstrap":            "libs/bootstrap/js/bootstrap.min",
		"zebra-dialog":			"libs/Zebra_Dialog/js/zebra_dialog",
		"WdatePicker":   		"libs/My97DatePicker/WdatePicker",
		"common":               "js/common"

	},
	"shim": {
		"bootstrap":            ["jquery"],
		"zebra-dialog":			["jquery"],
		"WdatePicker":			["jquery"],
		"common":               ["jquery","zebra-dialog"]
		
	}
});