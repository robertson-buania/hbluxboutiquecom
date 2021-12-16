package com.buania.buanialaxtechhblux.hbmedia;


import org.springframework.data.rest.core.config.Projection;

import java.util.Set;
@Projection(name="mediaProjection",types= {Hbmedia.class})
public interface HbmediaProjection {
    public Long getId();
    //public String getTypeMedia();
    //public String getMediaUrl();
    //public String getTailleString();
    //public Boolean getFavoris();
    //public Integer getLikes();

    //public Set<CommentaireProjection> getCommentaires();
}
