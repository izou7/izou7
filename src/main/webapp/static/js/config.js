requirejs.config( {
	"baseUrl": "/static",
	"paths": {
		"jquery":               "libs/jquery/jquery-2.0.3.min",
		"bootstrap":            "libs/bootstrap/js/bootstrap.min",
		"zebra-dialog":			"libs/Zebra_Dialog/js/zebra_dialog"


	},
	"shim": {
		"bootstrap":            ["jquery"],
		"zebra-dialog":			["jquery"]
	}
});