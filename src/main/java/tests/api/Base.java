package tests.api;

public class Base extends RestAssuredAPITest {
    public void main(String[] args) {

        RestAssuredAPITest rs = new RestAssuredAPITest();
        getArtist();
        getArtistAlbums();
        getArtistAlbumsNegative();
        createPlaylistNegative();

    }
}