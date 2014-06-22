package au.org.ala.downloads

import groovy.transform.ToString

@ToString
class Download {
    String name
    String description
    String fileUri
    String metadataUri
    String mimeType
    Long fileSize
    Date dataLastModified
    String dataEtag

    Date dateCreated
    Date lastUpdated

    static hasMany = [recordCount: RecordCount]

    static constraints = {
        name blank: false
        description blank: true, widget: 'textarea'
        fileUri blank: false, unique: true
        mimeType blank: true
        fileSize min: 1L
        dateCreated display: false
        lastUpdated display: false
        metadataUri nullable: true
    }

    static mapping = {
        dataEtag defaultValue: ''
    }
}
