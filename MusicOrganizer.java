import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
    /**
     * Metodo que muestra toda la lista de elementos
     */
    
    public void listAllFiles()
    {
        int posicion = 0;
        for(String nombreArchivo : files){
            System.out.println((posicion + 1) + " - " + nombreArchivo);
            posicion++;
        }
    }
    /**
     * Metodo que seleciona archivos solicitados por parametro
     */
    public void listMatching(String archivoABuscar)
    {
        boolean archivoEncontrado = false;
        for(String nombreArchivo : files){
            if(nombreArchivo.contains(archivoABuscar)){
                System.out.println(nombreArchivo);
                archivoEncontrado = true;
                
            }
            
        }
        if(archivoEncontrado == false){
            System.out.println("No se ha encontrado ningun resultado de busqueda");
        }
    }
    
    /**
     * Metodo que reproduce todas las  canciones de un artista en concreto
     */
    
    public void playAllArtist(String artista)
    {
        boolean artistaEncontrado = false;
        for(String nombreArchivo : files){
            if(nombreArchivo.contains(artista)){
                player.playSample(nombreArchivo);
                artistaEncontrado = true;
            }
            
        }
        if(artistaEncontrado == false){
            System.out.println("No hay canciones disponibles de: " + artista);
        }
    }
    
    /**
     * Metodo que busca el primer indice del archivo que corresponda al texto 
     * introducido por parametro
     */
    public int findFirst(String archivoABuscar)
    {
        int indice = 0;
        boolean buscando = true;
        int totalArchivos = files.size();
        while (indice < totalArchivos && buscando){
            //se crea una variable local para ir guardando los archivos
            String archivo = files.get(indice);
            if(archivo.contains(archivoABuscar)){
                buscando = false;
            }
            indice++;
        }
        if(buscando){
            indice = -1;
        }
        
        return indice;
    }
}
