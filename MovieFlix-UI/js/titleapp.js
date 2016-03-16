/**
 * Created by MyPC on 3/4/2016.
 */
(function() {
        'use strict';

        angular
            .module('movieflix', [])
            .controller('MainController', MainController);
        function MainController() {
            var movieVm = this;
            movieVm.title = 'Movie Flix';
            movieVm.cinemas = [{
                "Title": "Avengers: Age of Ultron",
                "Year": "2015",
                "Actors": "Robert Downey Jr., Chris Hemsworth, Mark Ruffalo, Chris Evans",
                "Genre": "Action, Adventure, Sci-Fi",
                "Director": "Joss Whedon",
                "imdbID": "tt2395427",
                "imdbRating": "7.6",
                "Plot": "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it's up to Earth's Mightiest Heroes to stop the villainous Ultron from enacting his terrible plans.",
                "Poster": "http://ia.media-imdb.com/images/M/MV5BMTU4MDU3NDQ5Ml5BMl5BanBnXkFtZTgwOTU5MDUxNTE@._V1_SX300.jpg"

            },

            ];


        }
    }
)();