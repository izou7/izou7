requirejs.config( {
	"baseUrl": "/static",
	"paths": {
		"jquery":               "libs/jquery/jquery-2.0.3.min",
		"bootstrap":            "libs/bootstrap/js/bootstrap.min"


	},
	"shim": {
		"bootstrap":            ["jquery"]
	}
});