package lesson22.Url.dto;

public class SearchReferences {
    public String id;                              // string 	false 	the unique id of the search_reference
    public String type;                           // the type of object this is, e.g. search_reference
    public ReferencedSearchReference attributes;  // The search_reference’s attributes, as a referenced search_reference object
}
