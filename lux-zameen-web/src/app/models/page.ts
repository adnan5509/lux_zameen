export interface Page<T> {
  content: T[];
  totalElements: number;
  totalPages: number;
  size: number;     // page size
  number: number;   // current page index
  first: boolean;
  last: boolean;
}
