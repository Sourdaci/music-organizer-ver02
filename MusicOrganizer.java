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
    * Prepara una base de canciones para trabajar en clase
    */
    public void addBaseFiles(){
        int i;
        String songs[] = {"creci en los 80", "nueva generacion", "game over", "paradise city"};
        for(i=0;i<4;i++){
            addFile("audio/" + songs[i] + ".mp3");
        }
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
     * Muestra por pantalla el nombre y posicion de todas las canciones almacenadas
     */
    public void listAllFiles(){
        if(files.size() > 0){
            int posicion = 1;
            for(String song : files){
                System.out.println(posicion + " -> " + song);
                posicion++;
            }
        }else{
            System.out.println("Lista de canciones vacia");
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
     * Muestra las canciones de la lista que contengan la cadena indicada
     */
    public void listMatching(String buscar){
        boolean encontrado = false;
        for(String filename : files){
            if(filename.contains(buscar)){
                encontrado = true;
                System.out.println(filename);
            }
        }
        if(!encontrado){
            System.out.println("No se encuentra ninguna cancion que contenga: " + buscar);
        }
    }
    
    /**
     * Realiza la preescucha de las canciones que contengan la cadena indicada
     */
    public void preListen(String buscar){
        boolean encontrado = false;
        for(String filename : files){
            if(filename.contains(buscar)){
                encontrado = true;
                player.playSample(filename);
            }
        }
        if(!encontrado){
            System.out.println("No se encuentra ninguna cancion que contenga: " + buscar);
        }
    }
    
    /**
     * Devuelve el indice de la lista del primer elemento que contenga la cadena buscada
     * Si no hay ningun elemento que la contenga, se devuelve -1
     */
    public int findFirst(String buscar){
        boolean found = false;
        int index = 0;
        int fileSize = files.size();
        while (!found && index < fileSize){
            if(files.get(index).contains(buscar)){
                found = true;
            }else{
                index++;
            }
        }
        if(!found){
            index = -1;
        }
        return index;
    }
}
