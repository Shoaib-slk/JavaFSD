let moviesList = [];
let favouriteMovies = [];

function getMovies() {
	return fetch('http://localhost:3000/movies').then(
		res => {
			if (res.ok) {
				return res.json()
			}
			else if (res.status == 404) {
				return Promise.reject(new Error('Invalid URL'));
			} else if (res.status == 401) {
				return Promise.reject(new Error('Unauthorised User...'));
			} else {
				return Promise.reject(new Error('Internal server error'));
			}
		}).then(data => {
			moviesList = data;
			displaymoviesList(moviesList);
			return data;
		}).catch(error => {
			const errorEle = document.getElementById('errorMovieName');
			errorEle.innerHTML = `<h2 style='color:red'>${error.message}</h2>`
			return error;
		})
}

function displaymoviesList(moviesList) {
	const ele = document.getElementById('moviesList');
	let htmlString = '';

	moviesList.forEach(movie => {
		htmlString += `
		<li class="list-group-item text-center d-flex justify-content-center">
		<div class="card " style="width: 20rem;">
		<img class="card-img-top" src="${movie.posterPath}" alt="Movie Poster">
		<div class="card-body">
			<h5 class="card-title">${movie.title}</h5>
			<button onclick="addFavourite('${movie.id}')" class="btn btn-outline-secondary mt-1 mb-2" type="button">Add to Favourites</button>
		</div>
		</div>
		</li>
		`;
	});
	ele.innerHTML = htmlString;
}

function getFavourites() {
	return fetch('http://localhost:3000/favourites').then(
		res => {
			if (res.ok) {
				return res.json()
			}
			else if (res.status == 404) {
				return Promise.reject(new Error('Invalid URL'));
			} else if (res.status == 401) {
				return Promise.reject(new Error('Unauthorised User...'));
			} else {
				return Promise.reject(new Error('Internal server error'));
			}
		}).then(data => {
			favouriteMovies = data;
			displayfavmoviesList(favouriteMovies);
			return data;
		}).catch(error => {
			const errorEle = document.getElementById('errorFavouriteMovieName');
			errorEle.innerHTML = `<h2 style='color:red'>${error.message}</h2>`
			return error;
		})
}

function displayfavmoviesList(moviesList) {
	const ele = document.getElementById('favouritesList');
	let htmlString = '';

	moviesList.forEach(movie => {
		htmlString += `
		<li class="list-group-item text-center d-flex justify-content-center">
		<div class="card" style="width: 20rem;">
		<img class="card-img-top" src="${movie.posterPath}" alt="Movie Poster">
		<div class="card-body">
			<h5 class="card-title">${movie.title}</h5>
			<button onclick="removeFavourite('${movie.id}')" class="btn btn-outline-secondary mt-1 mb-2" type="button">Remove</button>
		</div>
		</div></li>
		`
	});
	ele.innerHTML = htmlString;
}

function addFavourite(id) {
	let movieName = moviesList.find(movie => {
		if (movie.id == id) {
			return movie;
		}
	});
	let favExists = favouriteMovies.find(favMovie => {
		if (favMovie.id == movieName.id) {
			return favMovie;
		}
	})
	if (favExists) {
		return Promise.reject(new Error('Already Exist'));
	} else {
		return fetch(`http://localhost:3000/favourites`, {
			method: 'POST',
			headers: { 'content-type': 'application/json' },
			body: JSON.stringify(movieName)
		}).then(res => {
			if (res.ok) {
				return res.json();
			}
		}).then(addMovie => {
			favouriteMovies.push(addMovie);
			displayfavmoviesList(favouriteMovies);
			return favouriteMovies;
		})
	}
}

function removeFavourite(id) {
	let favExists = favouriteMovies.find(favMovie => {
		if (favMovie.id == id) {
			favouriteMovies.pop(favMovie);
			return favMovie;
		}
	})
	if (!favExists) {
		return Promise.reject(new Error('Movie does not Exist'));
	} else {
		return fetch(`http://localhost:3000/favourites/${favExists.id}`, {
			method: 'DELETE',
			headers: { 'content-type': 'application/json' }
		}).then(res => {
			if (res.ok) {
				return res.json();
			}
		}).then(removeMovie => {
			favouriteMovies.pop(removeMovie);
			displayfavmoviesList(favouriteMovies);
			return favouriteMovies;
		})
	}
}

module.exports = {
	getMovies,
	getFavourites,
	addFavourite
};

// You will get error - Uncaught ReferenceError: module is not defined
// while running this script on browser which you shall ignore
// as this is required for testing purposes and shall not hinder
// it's normal execution


