/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.backoffice.resources;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Administrator
 */
@Path("/catalogue")
public class CatalogueResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/liste")
    public Set liste(){
        if(Catalogue.listOfWorks.isEmpty()){
            Catalogue.listOfWorks.add(new Work("Rogue : L'Ultime Affrontement", 2007, new Artist("Jet Li"), "Action", "Depuis l'assassinat de son meilleur ami, l'agent du FBI Jack Crawford n'a plus qu'une obsession : retrouver Rogue, celui que tout désigne comme coupable, et faire justice lui-même. Mais comment attraper le plus redoutable des tueurs, un véritable fantôme capable d'apparaître n'importe où pour semer le chaos avant de s'évaporer dans la nature ?", "http://fr.web.img5.acsta.net/pictures/16/02/12/17/44/418323.jpg"));
            Catalogue.listOfWorks.add(new Work("Le transporteur", 2002, new Artist("Jason Statham"), "Action", "Frank Martin, ancien soldat des forces spéciales de reconnaissance, prête ses services de conducteur expert à quiconque le paie. Ses règles personnelles principales consistent à ne pas s'impliquer personnellement dans les affaires auxquelles il participe, de façon purement instrumentale.", "http://fr.web.img5.acsta.net/c_215_290/medias/nmedia/00/02/53/48/affiche2.jpg"));
            Catalogue.listOfWorks.add(new Work("Orgueil et Préjugés", 2005, new Artist("Keira Knightley"), "Comédie romantique", "Elizabeth (Keira Knightley), une belle fille à l'esprit vif qui observe la société où elle évolue et se moque volontiers des sots, rentrant d'une promenade matinale, entend sa mère annoncer qu'un certain Charles Bingley, jeune, riche et célibataire, a loué le domaine voisin de Netherfield, et s'y est installé avec sa sœur, Caroline, et son meilleur ami, Mr Darcy. Mrs Bennet espère que ce Bingley distinguera une de ses filles et que toute la famille en tirera profit. Mr Bennet consent à dire qu'il a rencontré Bingley et que ce dernier viendra au bal donné à Meryton.", "http://fr.web.img2.acsta.net/c_215_290/medias/nmedia/18/35/99/80/18461215.jpg"));
            Catalogue.listOfWorks.add(new Work("Warcraft : Le Commencement", 2016, new Artist("Travis Fimmel"), "Fantasy", "Draenor, le monde natal des Orcs, se meurt. Le sorcier démoniste Gul'dan unifie les tribus orcs au sein d’une Horde et use d’une puissante magie, le Fel (la Gangrène en VQ), afin d’ouvrir un portail vers Azeroth où une petite troupe de guerriers s’infiltre afin d’y réunir assez de prisonniers humains à sacrifier pour faire passer le restant de la Horde. ", "http://fr.web.img4.acsta.net/c_215_290/pictures/16/04/06/12/45/574116.jpg"));
        }
        
        return Catalogue.listOfWorks;
    }
}
