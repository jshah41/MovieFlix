(function() {
    'use strict';
    angular
        .module('plunker', ['ngMessages'])
        .filter('phone', phoneFilter)
        .controller('MainController', MainController);

    function phoneFilter() {
        return function(phoneStr) {
            var rez = [];

            //(XXX) XXX-XXXX
            if (phoneStr && phoneStr.length == 10) {
                rez.push('(')
                rez.push(phoneStr.substring(0, 3));
                rez.push(') ');
                rez.push(phoneStr.substring(3, 6));
                rez.push('-');
                rez.push(phoneStr.substring(6));
            }

            return rez.join('');
        }
    }

    function MainController() {
        var mainVm = this;

        mainVm.sortOrder = {
            by: 'name',
            reverse: false
        };

        mainVm.addUser = function(isValid) {
            if (isValid) {
                mainVm.newUser.id = mainVm.users.length + 1;
                mainVm.users.push(mainVm.newUser);
                console.log(mainVm.users);
                mainVm.newUser = null;
            }
        };

        mainVm.deleteUser = function(indexValue) {
            mainVm.users.splice(indexValue, 1);
            console.log(mainVm.users);
        }

        mainVm.users = [{
            "id": 1,
            "name": "Leanne Graham",
            "email": "Sincere@april.biz",
            "address": {
                "city": "Gwenborough",
                "zipcode": "92998-3874"
            },
            "phone": "7707368031",
            "website": "hildegard.org",
            "company": {
                "name": "Romaguera-Crona"
            }
        }, {
            "id": 2,
            "name": "Ervin Howell",
            "email": "Shanna@melissa.tv",
            "address": {
                "city": "Wisokyburgh",
                "zipcode": "90566-7771"
            },
            "phone": "6926593125",
            "website": "anastasia.net",
            "company": {
                "name": "Deckow-Crist"
            }
        }, {
            "id": 3,
            "name": "Clementine Bauch",
            "email": "Nathan@yesenia.net",
            "address": {
                "city": "McKenziehaven",
                "zipcode": "59590-4157"
            },
            "phone": "4631234447",
            "website": "ramiro.info",
            "company": {
                "name": "Romaguera-Jacobson"
            }
        }, {
            "id": 4,
            "name": "Patricia Lebsack",
            "email": "Julianne.OConner@kory.org",
            "address": {
                "city": "South Elvis",
                "zipcode": "53919-4257"
            },
            "phone": "4931709623",
            "website": "kale.biz",
            "company": {
                "name": "Robel-Corkery"
            }
        }, {
            "id": 5,
            "name": "Chelsey Dietrich",
            "email": "Lucio_Hettinger@annie.ca",
            "address": {
                "city": "Roscoeview",
                "zipcode": "33263"
            },
            "phone": "2549541289",
            "website": "demarco.info",
            "company": {
                "name": "Keebler LLC"
            }
        }, {
            "id": 6,
            "name": "Mrs. Dennis Schulist",
            "email": "Karley_Dach@jasper.info",
            "address": {
                "city": "South Christy",
                "zipcode": "23505-1337"
            },
            "phone": "4779358478",
            "website": "ola.org",
            "company": {
                "name": "Considine-Lockman"
            }
        }, {
            "id": 7,
            "name": "Kurtis Weissnat",
            "email": "Telly.Hoeger@billy.biz",
            "address": {
                "city": "Howemouth",
                "zipcode": "58804-1099"
            },
            "phone": "2100676132",
            "website": "elvis.io",
            "company": {
                "name": "Johns Group"
            }
        }, {
            "id": 8,
            "name": "Nicholas Runolfsdottir V",
            "email": "Sherwood@rosamond.me",
            "address": {
                "city": "Aliyaview",
                "zipcode": "45169"
            },
            "phone": "5864936943",
            "website": "jacynthe.com",
            "company": {
                "name": "Abernathy Group"
            }
        }, {
            "id": 9,
            "name": "Glenna Reichert",
            "email": "Chaim_McDermott@dana.io",
            "address": {
                "city": "Bartholomebury",
                "zipcode": "76495-3109"
            },
            "phone": "7759766794",
            "website": "conrad.com",
            "company": {
                "name": "Yost and Sons"
            }
        }, {
            "id": 10,
            "name": "Clementina DuBuque",
            "email": "Rey.Padberg@karina.biz",
            "address": {
                "city": "Lebsackbury",
                "zipcode": "31428-2261"
            },
            "phone": "2406483804",
            "website": "ambrose.net",
            "company": {
                "name": "Hoeger LLC"
            }

        }];
        mainVm.cinemas = [{
            "Title": "Avengers: Age of Ultron",
            "Year": "2015",
            "Actors": "Robert Downey Jr., Chris Hemsworth, Mark Ruffalo, Chris Evans",
            "Genre": "Action, Adventure, Sci-Fi",
            "Director": "Joss Whedon",
            "imdbID": "tt2395427",
            "imdbRating": "7.6",
            "Plot": "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it's up to Earth's Mightiest Heroes to stop the villainous Ultron from enacting his terrible plans.",
            "Poster": "http://ia.media-imdb.com/images/M/MV5BMTU4MDU3NDQ5Ml5BMl5BanBnXkFtZTgwOTU5MDUxNTE@._V1_SX300.jpg"

        }];

    }

})();