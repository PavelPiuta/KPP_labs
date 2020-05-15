import java.util.Random;

public class TestMultithreadedMergeSort {

    public static void main( String[] args ) {

        int arrSize = 20;
        int[] unsorted = new int[arrSize];
        Random randomizer = new Random();


        // Заполняем массив случайными значениями
        for ( int i = 0; i < arrSize; i++ ) {
            unsorted[i] = randomizer.nextInt( 10_000 );
        }
        StringBuilder firstString = new StringBuilder( "First array: " );
        for ( int i = 0; i < 20; i++ ) {
            firstString.append(unsorted[i]);
            firstString.append( " | " );
        }
        System.out.println( firstString.toString() );

        MultiMerger multiMerger = new MultiMerger( unsorted );
        multiMerger.start();
        // Ждем завершения потока
        try {
            multiMerger.join();
        } catch ( Exception e ) {

        }

        StringBuilder string1= new StringBuilder( "__________________________\r\n" );
        string1.append( "Multi Thread Sort: " );
        System.out.println( string1.toString() );
        int[] sorted = multiMerger.getSorted();
        StringBuilder resultString = new StringBuilder( "Sorted array examples: " );
        for ( int i = 0; i < 20; i++ ) {
            resultString.append( sorted[i] );
            resultString.append( " | " );
        }
        System.out.println( resultString.toString() );
    }
}