package chapter03;

public class SongTest {

	public static void main(String[] args) {
//		Song song = new Song();
		Song song01 = new Song("좋은날", "아이유","Real","이민수",3, 2010);
//		song.setTitle("좋은날");
//		song.setArtist("아이유");
//		song.setAlbum("Real");
//		song.setComposer("이민수");
//		song.setYear(2010);
//		song.setTrack(3);
		
		song01.show();
		
		Song song02 = new Song("Attention","뉴진스");
		song02.show();
	}

}
