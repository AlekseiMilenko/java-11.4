package ru.netology.domain;

public class BillboardManager {
    private Movie[] films = new Movie[0];
    private int limit = 10;

    public BillboardManager() {
    }

    public BillboardManager(int limit) {
        if (limit >= 10 || limit < 0) {
            limit = 10;
        } else {
            this.limit = limit;
        }
    }
    public int getLimit() {
        return limit;
    }

    public Movie[] getFilms() {
        return films;
    }

    public void add(Movie newMovie) {
        Movie[] tmp = new Movie[films.length + 1];

        System.arraycopy(films, 0, tmp, 0, films.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newMovie;
        films = tmp;
    }

    public Movie[] showLastFilms() {
        int resultLength;
        if (getLimit() >= films.length) {
            resultLength = films.length;
        } else {
            resultLength = getLimit();
        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}
