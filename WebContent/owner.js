function getUrlParameter( name, url ) {
  if (!url) url = location.href;
  name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
  var regexS = "[\\?&]"+name+"=([^&#]*)";
  var regex = new RegExp( regexS );
  var results = regex.exec( url );
  return results == null ? null : results[1];
}



app.controller('ownerController', function($scope, $http, $location, $window, API_URL) {    
    var companyId = getUrlParameter("companyId", window.location)
    
    //retrieve owners listing from API
    $http.get(API_URL + "getallowners")
            .success(function(response) {
                $scope.owners = response;
            });
    
    //show modal form
    $scope.toggle = function(modalstate, id) {
        $scope.modalstate = modalstate;

        switch (modalstate) {
            case 'add':
                $scope.form_title = "Add New Owner";
                break;
            case 'edit':
                $scope.form_title = "Owner Detail";
                $scope.id = id;
                $http.get(API_URL + 'getowner/' + id)
                        .success(function(response) {
                            console.log(response);
                            $scope.owner = response;
                        });
                break;
            default:
                break;
        }
        console.log("id=" + id);
        $('#modalOwner').modal('show');
    }

    //save new record / update existing record
    $scope.save = function(modalstate, id) {
        var url = API_URL;
        
        //append owner id to the URL if the form is in edit mode
        if (modalstate === 'edit'){
            url += "editowner/" + id;
        } else {
            url += "createowner";
        }
        
        $http({
            method: 'POST',
            url: url,
            data: JSON.stringify($scope.owner),
            headers: {'Content-Type': 'application/json'}
        }).success(function(response) {
            console.log(response);
            location.reload();
        }).error(function(response) {
            console.log(response);
            alert('This is embarassing. An error has occured. Please check the log for details');
        });
    }

    //delete record
    $scope.confirmDelete = function(id) {
        var isConfirmDelete = confirm('Are you sure you want this owner?');
        if (isConfirmDelete) {
            $http({
                method: 'DELETE',
                url: API_URL + 'deleteowner/' + id
            }).
                    success(function(data) {
                        console.log(data);
                        location.reload();
                    }).
                    error(function(data) {
                        console.log(data);
                        alert('Unable to delete');
                    });
        } else {
            return false;
        }
    }
});