package lesson22.Url.dto;

import java.util.List;

public class SearchReferences {
    public String id;   //	string 	false 	the unique id of the search_reference
    public String type; // 	string 	false 	the type of object this is, e.g. search_reference
    public List<ReferencedSearchReference> attributes; //ReferencedSearchReference 	false 	The search_reference’s attributes, as a referenced search_reference object

    public SearchReferences() {
    }
}
