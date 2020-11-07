var app = new Vue({
  // app initial state
  data: function () {
    return {
      firstName: '',
      lastName: '',
      userResponse: [],
      showNotification: false,
      showErrorNotification: false
    }
  },
  methods: {
	getUsers: function(firstName, lastName){
		 this.showNotification = false;
		$('#cover-spin').show(0);
		axios.get('/users', {
		    params: {
		    	firstName: firstName,
		    	lastName: lastName
		      }
	}).then((response) => {
			this.userResponse = [];
	      this.userResponse = response.data;
	      console.log(this.userResponse);
	      $('#cover-spin').hide(0);
	      if(this.userResponse.length == 0){
	    	  this.showNotification = true;
	      }
	      else{
	    	  this.showNotification = false;
	      }
	      this.firstName = '';
    	  this.lastName = '';
	    })
	    .catch((error) => {
	    	$('#cover-spin').hide(0);
	    	this.firstName = '';
	    	  this.lastName = '';
	    	  this.userResponse = [];
	    	if(error.response.status === 404){
	    		this.userResponse = [];
	    		this.showNotification = true;
	    		this.showErrorNotification = false;
	    	}
	    	else{
	    	this.showErrorNotification = true;
	    	}
	        console.log(error.response.data);
	    });
	},
	getAllUsers: function(){
		this.userResponse = [];
		 this.showNotification = false;
		$('#cover-spin').show(0);
		axios.get('/users').then((response) => {
	      this.userResponse = response.data;
	      console.log(this.userResponse)
	      $('#cover-spin').hide(0);
	      if(this.userResponse.length == 0){
	    	  this.showNotification = true;
	      }
	      else{
	    	  this.showNotification = false;
	      }
	    })
	    .catch((error) => {
	    	this.userResponse = [];
	    	$('#cover-spin').hide(0);
	    	if(error.response.status === 404){
	    		this.showNotification = true;
	    		this.showErrorNotification = false;
	    		this.userResponse = [];
	    	}
	    	else{
	    	this.showErrorNotification = true;
	    	}
	        console.log(error.response.data);
	    });
	}
  }
})

app.$mount('#index')