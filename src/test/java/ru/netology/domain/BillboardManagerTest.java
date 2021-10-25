package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillboardManagerTest {
    private BillboardManager manager = new BillboardManager();
    private Movie first = new Movie(1, "Matrix");
    private Movie second = new Movie(2, "Matrix 2");
    private Movie third = new Movie(3, "Matrix 3");
    private Movie fourth = new Movie(4, "Matrix 4");
    private Movie fifth = new Movie(5, "Fury 1");
    private Movie sixth = new Movie(6, "Fury 2");
    private Movie seventh = new Movie(7, "Fury 3");
    private Movie eighth = new Movie(8, "Fury 4");
    private Movie ninth = new Movie(9, "Lost 1");
    private Movie tenth = new Movie(10, "Lost 2");
    private Movie eleventh = new Movie(11, "Lost 3");

    @Test
    public void shouldShowLastFilmsDefaultEmpty() {
        BillboardManager manager = new BillboardManager();
        Movie[] actual = manager.showLastFilms();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastFilmsEmpty() {
        BillboardManager manager = new BillboardManager(8);
        Movie[] actual = manager.showLastFilms();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastFilmsOverLimitEmpty() {
        BillboardManager manager = new BillboardManager(20);
        Movie[] actual = manager.showLastFilms();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldAddFilmDefaultOneMovie() {
        BillboardManager manager = new BillboardManager();
        manager.add(first);
        int actual = manager.getFilms().length;
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldShowLastFilmsDefaultOneMovie() {
        BillboardManager manager = new BillboardManager();
        manager.add(first);
        Movie[] actual = manager.showLastFilms();
        Movie[] expected = new Movie[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastFilmsWithLimitOneMovie() {
        BillboardManager manager = new BillboardManager(7);
        manager.add(first);
        Movie[] actual = manager.showLastFilms();
        Movie[] expected = new Movie[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastFilmsOverLimitOneMovie() {
        BillboardManager manager = new BillboardManager(33);
        manager.add(first);
        Movie[] actual = manager.showLastFilms();
        Movie[] expected = new Movie[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddFilm() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        int actual = manager.getFilms().length;
        int expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldShowLastFilmsDefault() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Movie[] actual = manager.showLastFilms();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastFilmsOverDefault() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        Movie[] actual = manager.showLastFilms();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastFilmsWithLimit() {
        BillboardManager manager = new BillboardManager(2);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Movie[] actual = manager.showLastFilms();
        Movie[] expected = new Movie[]{tenth, ninth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastFilmsOverLimit() {
        BillboardManager manager = new BillboardManager(11);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Movie[] actual = manager.showLastFilms();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastFilmsZeroLimit() {
        BillboardManager manager = new BillboardManager(0);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Movie[] actual = manager.showLastFilms();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastFilmsNegativeLimit() {
        BillboardManager manager = new BillboardManager(-3);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        Movie[] actual = manager.showLastFilms();
        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

}