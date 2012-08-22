package org.rest.common.event;

import java.io.Serializable;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.common.base.Preconditions;

/**
 * Event that is fired when a resource was created. 
 * <p/>
 * This event object contains all the information needed to create the URL for access the new resource created
 * 
 * @param <T> Type of the result that is being handled (commonly Entities).
 */
public final class ResourceCreatedEvent<T extends Serializable> extends ApplicationEvent {
    private final long idOfNewResource;
    private final HttpServletResponse response;
    private final UriComponentsBuilder uriBuilder;

    public ResourceCreatedEvent(final Class<T> clazz, final UriComponentsBuilder uriBuilderToSet, final HttpServletResponse responseToSet, final long idOfNewResourceToSet) {
        super(clazz);

        Preconditions.checkNotNull(uriBuilderToSet);
        Preconditions.checkNotNull(responseToSet);
        Preconditions.checkNotNull(idOfNewResourceToSet);

        uriBuilder = uriBuilderToSet;
        response = responseToSet;
        idOfNewResource = idOfNewResourceToSet;
    }

    //

    public final UriComponentsBuilder getUriBuilder() {
        return uriBuilder;
    }

    public final HttpServletResponse getResponse() {
        return response;
    }

    public final long getIdOfNewResource() {
        return idOfNewResource;
    }

    /**
     * The object on which the Event initially occurred.
     * 
     * @return The object on which the Event initially occurred. 
     */
    @SuppressWarnings("unchecked")
    public final Class<T> getClazz() {
        return (Class<T>) getSource();
    }

}
